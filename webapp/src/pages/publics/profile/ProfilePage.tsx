import { useState, useEffect, useContext } from "react";
import {isAuthenticated} from "common/AuthenticationHelper";
import {Link,  } from 'react-router-dom'
import AuthContext from "context/authContext/AuthContext";
import "./ProfilePage.css"

export default function ProfilePage ({authenticationStatus}) {

    const {logoutUser} = useContext(AuthContext);

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);
    const [email , setEmail] = useState("");

    
    const getEmailByLocalStorage = () => {
        setEmail(localStorage.getItem("email"));
    }

    const onClickLogoutUser = () =>{
        setIsAuthenticatedState(false)
        logoutUser()
    }

    useEffect(() =>{
        setIsAuthenticatedState(isAuthenticated(authenticationStatus))
        if(isAuthenticatedState){
            getEmailByLocalStorage();
        }
    },[isAuthenticatedState]);

    return(
        <div>
            {!isAuthenticatedState
            ?<div className="profile_page_unauthorized">
                <p>Debes ingresar tu email para tener un perfil</p>  
                <Link 
                style={{ textDecoration: 'none' }}
                to="/">
                <p className="profile_page_redirect">Ir al Home</p>
                </Link>
            </div> 
            :<div className="profile_page_authorized">
                <div className="profile_page_authorized_info">
                    <img src="/user.png" alt="" />
                    <p>{email}</p>
                </div>
                <div className="profile_page_authorized_buttons">
                    <p onClick={onClickLogoutUser}>cerrar sesion</p>
                    <p>cambiar email</p>
                </div>
            </div>}
        </div>
    )
}