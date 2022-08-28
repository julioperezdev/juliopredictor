import {useState} from "react"
import "./EmailInput.css"

import Swal from "sweetalert2"
import { LoginRequestDto } from "../../../models/LoginRequestDto";

export const EmailInput = ({decideAuth}) =>{

    const [email, setEmail] = useState(null);

    const emailChange = (emailByEvent:string) =>{
        setEmail(emailByEvent);
    }

    const onPressEnterButtonToCatchEmail = async(event) =>{
        if(event.key === 'Enter'){
            event.preventDefault();
            const emailValidation : boolean = checkIfEmail(email);
            if(!emailValidation){
                await showPopupByBadEmailSyntax();
            }
            if(emailValidation){
                buildToSendUser();
            }
        }
    }
    const onClickToCatchEmail = () =>{
        const emailValidation : boolean = checkIfEmail(email);
        if(!emailValidation){
            showPopupByBadEmailSyntax();
        }
        if(emailValidation){
            buildToSendUser();
        }
    }

    const showPopupByBadEmailSyntax = async() =>{
        setEmail("");
        await Swal.fire({
            icon: 'warning',
            title: 'Detectamos que no es un email',
            text: 'Debe tener un formato correcto',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Entendido'
        })
    }

    const buildToSendUser = () => {
        const user : LoginRequestDto = {email};
        decideAuth(user);
        setEmail("");
    }

    const checkIfEmail = (email : string) : boolean => {
        const regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi;
        return regexExp.test(email);
    }

    return(
        <div  className="email-input-state0-email">
            <input 
            className="email-input-state0"
            type="email" 
            value={email}
            placeholder="coloca el email"
            maxLength={40}
            onChange={(event) => emailChange(event.target.value)}
            onKeyDownCapture={onPressEnterButtonToCatchEmail}/>
            <img 
            itemType="submit"
            onClick={onClickToCatchEmail}
            src="image/arrow-right.png" alt="" />
        </div>
    )
}