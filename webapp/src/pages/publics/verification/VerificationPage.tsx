import { useContext, useEffect, useState } from "react";
import {Link } from 'react-router-dom'
import AuthContext from "../../../context/authContext/AuthContext";


export const VerificationPage = () => {

    const {verifyToken} = useContext(AuthContext);

    const [query, setQuery] = useState(false);

    const getTokenByUrl = () : string =>{
        let urlEvent : string = window.location.href;
        let url = new URL(urlEvent);
        let searchParams = new URLSearchParams(url.search);
        return searchParams.get('token');
        //console.log(searchParams.get('c'));  // outputs "m2-m3-m4-m5"
    }


    useEffect(() =>{
        if(localStorage.getItem("isAuthenticated") === "true"){
            setQuery(true);
        }
        if(localStorage.getItem("isAuthenticated") != "true"){
            let tokenToChangeEnableStatus : string =  getTokenByUrl();
            verifyToken(tokenToChangeEnableStatus);
        }    
    },[localStorage.getItem("isAuthenticated")])

    return(
        <>
        <h1>Has been verified successfully</h1>
        <Link
        to="/">
        <h1>Go home</h1>
        </Link>
        {/* {!query ? <>hola</> : window.location.href = "http://localhost:3000"} */}
        </>
        /*
        !query
        ?<h1>estamos verificando<h1/>
        :<Redirect to="/"/>
        */
        
    )
}

