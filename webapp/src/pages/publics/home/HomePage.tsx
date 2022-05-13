import {UserVerificator} from "../../../components/home/user-verificator/UserVerificator"
import {FavoriteCrypto} from "../../../components/home/favorite-crypto/FavoriteCrypto"

import "./HomePage.css"

export const HomePage = () =>{
    
    const UNAUTHENTICATED : number = 0;
    const AUTHENTICATION_IN_PROCESS : number = 1;
    const AUTHENTICATED : number = 2;

    const authenticationStatus : number = 0;
    return(
        <>
        <div className="home-page-base">
            <UserVerificator 
            authenticationStatus ={authenticationStatus}/>
            <FavoriteCrypto
            authenticationStatus ={authenticationStatus}/>
        </div>
        {/* <p>userComponent</p>
        <p>favoriteList</p>
        <p>top5Currencies</p>
        <p>socialMedia</p> */}
        </>
    )
}