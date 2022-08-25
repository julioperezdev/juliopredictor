import {useEffect} from "react"
import {UserVerificator} from "../../../components/home/user-verificator/UserVerificator"
import {FavoriteCrypto} from "../../../components/home/favorite-crypto/FavoriteCrypto"
import {TopFourCryptos} from "../../../components/home/topFourCryptos/TopFourCryptos"

import "./HomePage.css"

export const HomePage = ({authenticationStatus,decideAuth,decideStatus}) =>{

    useEffect(() =>
    {decideStatus()},
    [localStorage.getItem("email"), 
    localStorage.getItem("isAuthenticated"), 
    localStorage.getItem("token")]);

    return(
        <>
        <div className="home-page-base">
            <UserVerificator 
            authenticationStatus ={authenticationStatus}
            decideAuth = {decideAuth}/>
            <FavoriteCrypto
            authenticationStatus ={authenticationStatus}
            decideAuth = {decideAuth}/>
            <TopFourCryptos
            authenticationStatus ={authenticationStatus}/>
        </div>
        </>
    )
}