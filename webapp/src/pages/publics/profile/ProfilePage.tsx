import { useState, useEffect, useContext } from "react";
import {isAuthenticated} from "common/AuthenticationHelper";
import {Link,  } from 'react-router-dom'
import AuthContext from "context/authContext/AuthContext";
import "./ProfilePage.css"
import Swal from "sweetalert2";
import { LoginRequestDto } from "models/LoginRequestDto";

export default function ProfilePage ({authenticationStatus}) {

    const {logoutUser, decideAuth} = useContext(AuthContext);

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);
    const [isChangeEmail, setIsChangeEmail] = useState(false);
    const [newUser, setNewUser] = useState(null);
    const [email, setEmail] = useState("");
    
    const getEmailByLocalStorage = () => {
        setEmail(localStorage.getItem("email"));
    }

    const onClickLogoutUser = () =>{
        setIsAuthenticatedState(false)
        logoutUser()
    }
    
    const onClickChangeUser = () =>{
        setIsChangeEmail(true)
        
    }

    const checkIfEmail = (email : string) : boolean => {
        const regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi;
        return regexExp.test(email);
    }

    const alertFunction = () =>{
        const emailValidation : boolean = checkIfEmail(newUser);
        if(!emailValidation){
            setNewUser("");
            Swal.fire({
                icon: 'warning',
                title: 'Detectamos que no es un email',
                text: 'Debe tener un formato correcto',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Entendido'
              })
        }
        if(emailValidation){
            const user : LoginRequestDto = {email: newUser}
            decideAuth(user);
            setNewUser("");
        }
    }

    const emailChange = (emailByEvent:string) =>{
        setNewUser(emailByEvent);
    }

    const onClickCancelChangeEmail = () =>{
        setNewUser(null);
        setIsChangeEmail(false)
    }

    useEffect(() =>{
        setIsAuthenticatedState(isAuthenticated(authenticationStatus))
        if(isAuthenticatedState){
            getEmailByLocalStorage();
        }
    },[isAuthenticatedState]);

    return(
        <>
        {
            !isChangeEmail 
            ?<div>
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
                <div>
                    <Link 
                    style={{ textDecoration: 'none' }}
                    to="/">
                    <p 
                    className="profile_page_authorized_buttons"
                    onClick={onClickLogoutUser}>cerrar sesion</p>
                    </Link>
                    <p 
                    className="profile_page_authorized_buttons"
                    onClick={onClickChangeUser}>cambiar email</p>
                </div>
            </div>}
            </div> 
            :<div>
                <p>Escriba el nuevo email</p>
                <input 
                type="email" 
                value={newUser}
                placeholder="coloca el email"
                maxLength={40}
                onChange={(event) => emailChange(event.target.value)}/>
                <div>
                    <button onClick={alertFunction}>confirmar</button>
                    <button onClick={onClickCancelChangeEmail}>cancelar</button>
                </div>
            </div>
        }
        </>
    )
}