import { useState, useEffect } from "react";
import {isAuthenticated} from "common/AuthenticationHelper";
import {Link } from 'react-router-dom'

export default function ProfilePage ({authenticationStatus}) {

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);

    useEffect(() =>{setIsAuthenticatedState(isAuthenticated(authenticationStatus))},[]);

    return(
        <div>
            <img src="/user.png" alt="" />
            <div>
                {!isAuthenticatedState
                ?<div>
                  <p>Debes ingresar tu email para tener un perfil</p>  
                  <Link 
                  style={{ textDecoration: 'none' }}
                  to="/">
                    <p>Ir al Home</p>
                  </Link>
                </div> 
                :<div></div>}
            </div>
        </div>
    )
}