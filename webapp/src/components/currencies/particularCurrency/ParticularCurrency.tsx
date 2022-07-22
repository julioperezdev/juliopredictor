import {useEffect, useState} from "react"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity";
import "./ParticularCurrency.css"

export const ParticularCurrency = (particularCurrency : CoinMarketCapMapEntity) => {

    const [favorites, setFavorites] = useState<CoinMarketCapMapEntity>(null);
    const [hasFavorite, setHasFavorite] = useState<boolean>(false);

    const isFavoriteCrypto = async () => {
        if(localStorage.getItem("favoritesCryptos") != null){
            let favoritesLocalStorage : Array<string> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
            favoritesLocalStorage.find(storageCurrency => particularCurrency.symbol === storageCurrency) === undefined ?
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
        let favoritesLocalStorage : Array<string>;
        if(localStorage.getItem("favoritesCryptos") != null){
            favoritesLocalStorage = await JSON.parse(localStorage.getItem("favoritesCryptos"));
        }
        console.log(particularCurrency.symbol)
        let symbol : string = particularCurrency.symbol;
        favoritesLocalStorage.push(...favoritesLocalStorage,symbol);
        console.log(favoritesLocalStorage)
        localStorage.setItem("favoritesCryptos", JSON.stringify(favoritesLocalStorage));
        setHasFavorite(true);
    }

    const depurateFavoriteCryptoLocalStorage = async () =>{
        let favoritesLocalStorage : Array<string> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
        favoritesLocalStorage.filter( particularFavorites => particularFavorites != particularCurrency.symbol);
        localStorage.setItem("favoritesCryptos", JSON.stringify(favoritesLocalStorage));
        setHasFavorite(false);
    }
    
        

    useEffect(() => {
        isFavoriteCrypto();
    },[localStorage.getItem("favoritesCryptos")])

    return(
        <div 
        className="particular-currency-base" 
        key={particularCurrency.id}
        onClick={() => onClickToChangeFavorite()}>
            <p>{particularCurrency.rank}</p>
            <p>{particularCurrency.symbol}</p>    
            <p>{particularCurrency.name}</p>
            {/* <img src="/image/heart-red.png" alt="" />   
            <img src="" alt="" />     */}
            {hasFavorite 
            ? <img src="/image/heart-red.png" alt="" /> 
            : <img src="/image/heart.png" alt="" />}
        </div>
    )
} 