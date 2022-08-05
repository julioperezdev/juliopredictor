import { CoinMarketCapMapEntity } from "models/CoinMarketCapMapEntity";
import { FavoritesCryptos } from "models/FavoritesCryptos";
import { useEffect, useState } from "react";

export default function FavoriteCryptoList(){
    const [favorites, setFavorites] = useState<CoinMarketCapMapEntity>(null);
    const [hasFavorite, setHasFavorite] = useState<boolean>(false);

    const [favoriteChange, setFavoriteChange] = useState<boolean>(false);
    const [favoritesCryptos, setFavoritesCryptos] = useState([]);
    const [hasFavoritesCryptos, setHasFavoritesCryptos] = useState(false)

    const getFavoriteCryptoFromLocalStorage = async() =>{
        if(localStorage.getItem("favoritesCryptos") != null){
            let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
            setFavoritesCryptos(favoritesLocalStorage);
            setHasFavoritesCryptos(true);
        }
    }

    const depurateFavoriteCryptoLocalStorage = async (particularCurrency) =>{
        let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
        let favoritesLocalStorageFiltered : Array<FavoritesCryptos> = favoritesLocalStorage.filter( particularFavorites => particularFavorites.symbol != particularCurrency.symbol);
        localStorage.removeItem("favoritesCryptos");
        if(favoritesLocalStorageFiltered.length !== 0){
            localStorage.setItem("favoritesCryptos", JSON.stringify(favoritesLocalStorageFiltered));
        }
        if(favoritesLocalStorageFiltered.length === 0){
            setFavoritesCryptos([]);
            setHasFavoritesCryptos(false);
        }
        setFavoriteChange(!favoriteChange);
    }

    useEffect(() =>{getFavoriteCryptoFromLocalStorage()},[favoriteChange])
    return(
        <div>
            {favoritesCryptos.map(particular => (
                <li>
                    <p>{particular.symbol}</p>    
                    <p>{particular.name}</p>    
                    <img onClick={() => depurateFavoriteCryptoLocalStorage(particular)} src="/image/heart-red.png" alt="" /> 
                    <img src="/image/arrow-right-purple.png" alt="" />
                </li>
            ))}
        </div>
    )
}