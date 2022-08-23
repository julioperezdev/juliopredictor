import FavoriteCryptoList from "components/favorites/favoriteCryptoList/FavoriteCryptoList";
import { useState, useEffect } from "react";
import {isAuthenticated} from "common/AuthenticationHelper";

import "./FavoritesPage.css";

export const FavoritesPage = ({authenticationStatus}) =>{

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);

    useEffect(() =>{setIsAuthenticatedState(isAuthenticated(authenticationStatus))},[]);
    
    return(
        <>
        {isAuthenticatedState
        ? <div><FavoriteCryptoList/></div>
        : <div className="favorite_page_unauthorize">
            <h1>Debe autenticarse agregando su email en la pagina principal</h1>
            <img src="/labor.png" alt="" />    
        </div>}
        </>
    )
}