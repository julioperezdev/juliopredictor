import "./UserVerificator.css"

export const UserVerificator = ({authenticationStatus}) =>{

    const stringCreator = (value:string, quantity:number):string =>{
        return value.length > quantity ? value.slice(0, quantity).concat("..."): value;
    }

    return(
        <div 
        className={"user-verificator-base user-verificator-".concat(authenticationStatus.toString())}>
            {(() => {
                switch(authenticationStatus){
                case 0:
                    return <>
                    <div className="">
                        <img 
                        src="image/add.png" 
                        className="" />
                        <p>Agregar email</p>
                    </div>
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
