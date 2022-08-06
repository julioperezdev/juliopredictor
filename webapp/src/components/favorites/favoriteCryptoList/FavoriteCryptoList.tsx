import { FavoritesCryptos } from "models/FavoritesCryptos";
import { useEffect, useState } from "react";

import "./FavoriteCryptoList.css"

export default function FavoriteCryptoList(){

    const [favoriteChange, setFavoriteChange] = useState<boolean>(false);
    const [favoritesCryptos, setFavoritesCryptos] = useState([]);

    const getFavoriteCryptoFromLocalStorage = async() =>{
        if(localStorage.getItem("favoritesCryptos") != null){
            let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
            setFavoritesCryptos(favoritesLocalStorage);
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
        }
        setFavoriteChange(!favoriteChange);
    }

    useEffect(() =>{getFavoriteCryptoFromLocalStorage()},[favoriteChange])
    return(
        <div className="favorite_crypto_list_base">
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