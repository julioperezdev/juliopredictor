import { useContext, useEffect, useState } from "react"
import AuthContext from "../../../context/authContext/AuthContext"

import {UserVerificator} from "../../../components/home/user-verificator/UserVerificator"
import {FavoriteCrypto} from "../../../components/home/favorite-crypto/FavoriteCrypto"
import {TopFourCryptos} from "../../../components/home/topFourCryptos/TopFourCryptos"

import "./HomePage.css"

export const HomePage = () =>{
    
    const UNAUTHENTICATED : number = 0;
    const AUTHENTICATION_IN_PROCESS : number = 1;
    const AUTHENTICATED : number = 2;

    const {decideAuth} = useContext(AuthContext);

    const [authenticationStatus, setAuthenticationStatus] = useState(UNAUTHENTICATED);

    const checkIfEmail = (email : string) : boolean => {
        const regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi;
        return regexExp.test(email);
    }

    const decideStatus = () => {
        const verifyEmailLocalStorage : boolean = checkIfEmail(localStorage.getItem("email"));
        const verifyIsAuthenticatedLocalStorage : boolean = localStorage.getItem("isAuthenticated") === "true";

        if(!verifyEmailLocalStorage){
            setAuthenticationStatus(UNAUTHENTICATED);
        }
        if(verifyEmailLocalStorage && !verifyIsAuthenticatedLocalStorage){
            setAuthenticationStatus(AUTHENTICATION_IN_PROCESS);
        }
        if(verifyEmailLocalStorage && verifyIsAuthenticatedLocalStorage){
            setAuthenticationStatus(AUTHENTICATED);
        }
    }

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