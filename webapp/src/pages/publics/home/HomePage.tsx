import {UserVerificator} from "../../../components/home/user-verificator/UserVerificator"

import "./HomePage.css"

export const HomePage = () =>{
    
    const UNAUTHENTICATED : number = 0;
    const AUTHENTICATION_IN_PROCESS : number = 1;
    const AUTHENTICATED : number = 2;

    const authenticationStatus : number = 1;
    return(
        <>
        <div className="home-page-base">
            <UserVerificator 
            authenticationStatus ={authenticationStatus}/>
        </div>
        {/* <p>userComponent</p>
        <p>favoriteList</p>
        <p>top5Currencies</p>
        <p>socialMedia</p> */}
        </>
    )
}