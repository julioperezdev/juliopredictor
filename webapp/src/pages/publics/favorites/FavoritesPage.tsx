import {isAuthenticated} from "common/AuthenticationHelper"
import { useEffect } from "react";
import { useState } from "react"

export const FavoritesPage = ({authenticationStatus}) =>{

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);



    useEffect(() =>{setIsAuthenticatedState(isAuthenticated(authenticationStatus))},[]);

    
    return(
        <>
        {isAuthenticatedState? <div></div>: <div></div>}
        </>
    )
}

//FavoritesCryptos