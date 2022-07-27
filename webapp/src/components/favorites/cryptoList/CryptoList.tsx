import { FavoritesCryptos } from "models/FavoritesCryptos";
import { useState } from "react";
import { useEffect } from "react";
import {CryptoRankedByCmc} from "../../../models/Models"
import "./CryptoList.css"

export const CryptoList = ({favoriteCryptosByUser}) =>{

    const [favoritesCryptos, setFavoritesCryptos] = useState([]);
    const [hasFavoritesCryptos, setHasFavoritesCryptos] = useState(false)
    const [favoriteChange, setFavoriteChange] = useState<boolean>(false);

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
    
    const favoriteCryptos: Array<CryptoRankedByCmc> = favoriteCryptosByUser;
    return (
        <>{
            hasFavoritesCryptos
            ?<div className="crypto-list-base">
                <div>
                    <p></p>    
                    <p>FAVORITES</p>    
                    <p></p>
                </div>
                <ul className="crypto-list-ul">
                    {favoritesCryptos.map(particular => (
                    <li>
                        <p>{particular.symbol}</p>    
                        <p>{particular.name}</p>    
                        <img onClick={() => depurateFavoriteCryptoLocalStorage(particular)} src="/image/heart-red.png" alt="" /> 
                    </li>
                    ))}
                </ul>
            </div>
            :<p>no tiene favoritos</p>    
        }</>
    )
}