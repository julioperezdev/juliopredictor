import { FavoritesCryptos } from "models/FavoritesCryptos";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import AlertEmptyCryptoList from "../alertEmptyCryptoList/AlertEmptyCryptoList";

import "./FavoriteCryptoList.css"

export default function FavoriteCryptoList(){

    const [favoriteChange, setFavoriteChange] = useState<boolean>(false);
    const [favoritesCryptos, setFavoritesCryptos] = useState([]);
    const [hasFavoritesCryptos, setHasFavoritesCryptos] = useState<boolean>(true);

    const validateIfHasFavoritesCryptos = (favoritesCryptos : Array<any>) => {
        let validationResult: boolean = favoritesCryptos.length > 0 ? true : false;
        setHasFavoritesCryptos(validationResult);
    }

    const getFavoriteCryptoFromLocalStorage = async() =>{
        if(localStorage.getItem("favoritesCryptos") === null){
            let emptyArray = validateIfHasFavoritesCryptos([])
        }
        if(localStorage.getItem("favoritesCryptos") != null){
            let favoritesLocalStorage : Array<FavoritesCryptos> = await JSON.parse(localStorage.getItem("favoritesCryptos"));
            setFavoritesCryptos(favoritesLocalStorage);
            validateIfHasFavoritesCryptos(favoritesLocalStorage)
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
            let emptyArray = [];
            setFavoritesCryptos(emptyArray);
            validateIfHasFavoritesCryptos(emptyArray);
        }
        setFavoriteChange(!favoriteChange);
    }

    useEffect(() =>{getFavoriteCryptoFromLocalStorage()},[favoriteChange])
    return(
        <div className="favorite_crypto_list_base">
            {!hasFavoritesCryptos ? <AlertEmptyCryptoList/> 
            :<>
            {favoritesCryptos.map(particular => (
                <li>
                    <p>{particular.symbol}</p>    
                    <p>{particular.name}</p>    
                    <img className="favorite_crypto_list_image"  onClick={() => depurateFavoriteCryptoLocalStorage(particular)} src="/image/heart-red.png" alt="" /> 
                    <Link
                    to={`/crypto/${particular.id}`}>
                    <img 
                    className="favorite_crypto_list_image" 
                    src="/image/arrow-right-purple.png"/>
                    </Link>
                    
                </li>
            ))}
            </>}
            
        </div>
    )
}