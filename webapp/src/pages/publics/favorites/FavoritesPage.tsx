import {isAuthenticated} from "common/AuthenticationHelper"
import { CryptoList } from "components/favorites/cryptoList/CryptoList";
import FavoriteCryptoList from "components/favorites/favoriteCryptoList/FavoriteCryptoList";
import { useEffect } from "react";
import { useState } from "react"

export const FavoritesPage = ({authenticationStatus}) =>{

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);



    useEffect(() =>{setIsAuthenticatedState(isAuthenticated(authenticationStatus))},[]);

    
    return(
        <>
        {isAuthenticatedState? <div><FavoriteCryptoList/></div>: <div>tiene que autenticarse</div>}
        </>
    )
}

//FavoritesCryptos