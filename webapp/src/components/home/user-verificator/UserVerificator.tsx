import {useContext, useEffect, useState} from "react"
import {EmailInput} from "../../common/emailInput/EmailInput"
import "./UserVerificator.css"
import AuthContext from "../../../context/authContext/AuthContext"
import { LoginRequestDto } from "../../../models/LoginRequestDto"

export const UserVerificator = ({authenticationStatus, decideAuth}) =>{

    
    //const {decideAuth} = useContext(AuthContext);
    
    const [useAddEmail, setUseAddEmail] = useState(false);

    const stringCreator = (value:string, quantity:number):string =>{
        return value.length > quantity ? value.slice(0, quantity).concat("..."): value;
    }
    

    const onClickAddEmail = () =>{
        setUseAddEmail(true)
    }

    const ppp = () =>{
        console.log("JEJEJE")
    }

    
    useEffect(() =>{
        /*const request = {
            email: "mario@email.com",
            idRol: 1
        }
        //signupUser(request);
        ppp()
        */
       //const user : LoginRequestDto = {email : "perezjulioernesto@gmail.com"}
        //decideAuth(user)
    },[useAddEmail])

    
    return(
        <div 
        className={"user-verificator-base user-verificator-".concat(authenticationStatus.toString())}>
            {(() => {
                switch(authenticationStatus){
                case 0:
                    return <>
                    {!useAddEmail?
                    <div
                    onClick={() => onClickAddEmail()}>
                        <img 
                        src="image/add.png"/>
                        <p>Agregar email</p>
                    </div>:
                    <EmailInput
                    decideAuth = {decideAuth}/>}
                    <div>
                        <img 
                        src="image/cross.png" 
                        alt="" />
                        <p>Sin verificacion</p>
                    </div>
                    </>    

                case 1:
                    return <>
                    <div>
                        <img 
                        src="image/user3.png" 
                        className="" />
                        <p>{stringCreator("perezjulioernesto@gmail.com", 30)}</p>
                    </div>
                    <div>
                        <img 
                        src="image/clock5.png" 
                        alt="" />
                        <p>A espera de validacion</p> 
                    </div>
                    </>
                case 2:
                    return <>
                    <div>
                        <img 
                        src="image/user2.png" 
                        className="" />
                        <p>{stringCreator("perezjulioernesto@gmail.com", 30)}</p>
                    </div>
                    <div>
                        <img 
                        src="image/check.png" 
                        alt="" />
                        <p>Verificado</p> 
                    </div>
                    </>
                }})()}
        </div>
    )
}
