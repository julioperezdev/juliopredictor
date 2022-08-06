import {useEffect, useState} from "react"
import { Link } from "react-router-dom";
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity";
import { FavoritesCryptos } from "../../../models/FavoritesCryptos";
import "./ParticularCurrency.css"

export const ParticularCurrency = (particularCurrency : CoinMarketCapMapEntity) => {

    const [favorites, setFavorites] = useState<CoinMarketCapMapEntity>(null);
    const [hasFavorite, setHasFavorite] = useState<boolean>(false);

    const isFavoriteCrypto = async () => {
        if(localStorage.getItem("favoritesCryptos") != null){
            let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
            favoritesLocalStorage.find(storageCurrency => particularCurrency.symbol === storageCurrency.symbol) === undefined ?
            setHasFavorite(false) : 
            setHasFavorite(true);
        }else{
            setHasFavorite(false)
        }
    }

    const onClickToChangeFavorite = async () => {
        hasFavorite ? depurateFavoriteCryptoLocalStorage() : addFavoriteCryptoLocalStorage();
    }

    const addFavoriteCryptoLocalStorage = async () =>{
        let favoritesLocalStorage : Array<FavoritesCryptos> = [];
        if(localStorage.getItem("favoritesCryptos") != null){
            favoritesLocalStorage = await JSON.parse(localStorage.getItem("favoritesCryptos"));
        }
        let favoritesCryptos : FavoritesCryptos = {
            id : particularCurrency.id,
            name : particularCurrency.name,
            symbol : particularCurrency.symbol
        }
        favoritesLocalStorage.push(favoritesCryptos);  
        localStorage.setItem("favoritesCryptos", JSON.stringify(favoritesLocalStorage));
        setHasFavorite(true);
    }

    const depurateFavoriteCryptoLocalStorage = async () =>{
        let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
        let favoritesLocalStorageFiltered : Array<FavoritesCryptos> = favoritesLocalStorage.filter( particularFavorites => particularFavorites.symbol != particularCurrency.symbol);
        localStorage.removeItem("favoritesCryptos");
        if(favoritesLocalStorageFiltered.length > 0){
            localStorage.setItem("favoritesCryptos", JSON.stringify(favoritesLocalStorageFiltered));
        }
        setHasFavorite(false);
    }
    
        

    useEffect(() => {
        isFavoriteCrypto();
    },[localStorage.getItem("favoritesCryptos")])

    return(
        <div 
        className="particular-currency-base" 
        key={particularCurrency.id}>
            <p>{particularCurrency.rank}</p>
            <p>{particularCurrency.symbol}</p>    
            <p>{particularCurrency.name}</p>
            {hasFavorite 
            ? <img className="particular-currency-image" onClick={() => onClickToChangeFavorite()} src="/image/heart-red.png" alt="" /> 
            : <img className="particular-currency-image" onClick={() => onClickToChangeFavorite()} src="/image/heart-purple.png" alt="" />}
            <Link
            to={`/crypto/${particularCurrency.id}`}>
            <img 
            className="particular-currency-image"
            src="/image/arrow-right-purple.png" />
            </Link>
            
        </div>
    )
} 