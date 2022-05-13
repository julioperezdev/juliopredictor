import {useState} from "react"
import {EmailImput} from "../../common/emailInput/EmailImput"
import "./UserVerificator.css"

export const UserVerificator = ({authenticationStatus}) =>{

    const [useAddEmail, setUseAddEmail] = useState(false);

    const stringCreator = (value:string, quantity:number):string =>{
        return value.length > quantity ? value.slice(0, quantity).concat("..."): value;
    }

    const onClickAddEmail = () =>{
        setUseAddEmail(true)
    }

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
                    <EmailImput/>}
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
