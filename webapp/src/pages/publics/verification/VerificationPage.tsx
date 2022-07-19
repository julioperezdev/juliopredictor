import { useContext, useEffect, useState } from "react";
import {Link } from 'react-router-dom'
import AuthContext from "../../../context/authContext/AuthContext";
import { LoginRequestDto } from "../../../models/LoginRequestDto";


export const VerificationPage = () => {

    const {verifyToken, decideAuth} = useContext(AuthContext);

    const [query, setQuery] = useState(false);

    const getTokenByUrl = () : string =>{
        let urlEvent : string = window.location.href;
        let url = new URL(urlEvent);
        let searchParams = new URLSearchParams(url.search);
        return searchParams.get('token');
    }

    const processToValidateAndThenLogin = async () => {
        let tokenToChangeEnableStatus : string = getTokenByUrl();
        await verifyToken(tokenToChangeEnableStatus);
        const email : string = localStorage.getItem("email");
        const user : LoginRequestDto = {email}
        await decideAuth(user);
    }


    useEffect(() =>{
        processToValidateAndThenLogin();
    },[])

    return(
        <>
        <h1>Has been verified successfully</h1>
        <Link
        to="/">
        <h1>Go home</h1>
        </Link>
        </>        
    )
}

