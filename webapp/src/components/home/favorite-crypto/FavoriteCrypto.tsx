import {EmailImput} from "../../common/emailInput/EmailImput"
import "./FavoriteCrypto.css"

export const FavoriteCrypto = ({authenticationStatus}) =>{

    const hasFavoriteCryptos = () =>{
        var favoriteCrytos: Array<number> = [];
        return favoriteCrytos.length != 0;
    }

    return(
        <div className={"favorite-crypto-base favorite-crypto-base-".concat(authenticationStatus.toString())}>
            {(() => {
                switch(authenticationStatus){
                case 0:
                    return <>
                    <div>
                        <div>
                            <p>Agregando tu email escoges favoritos</p>
                            <img src="image/alarm.png" alt="" />
                        </div>
                        <EmailImput/>
                    </div>
                    </>    

                case 1:
                    return <>
                    <div>
                        <p>Sin validarte en el email no podrás escoger criptomonedas favoritos</p>
                        <img src="/image/email2.png" alt="" />
                    </div>
                    </>
                case 2:
                    return <>
                    <div>
                        {!hasFavoriteCryptos()? 
                        <>
                            <p>No tienes criptomonedas favoritas</p>
                            <img src="/image/add.png" alt="" />
                        </>
                        :
                        <>
                            <p>cripto 1</p>
                            <p>cripto 2</p>
                            <p>cripto 3</p>
                            <p>cripto 4</p>
                            <p>cripto 5</p>
                        </>}
                    </div>
                    </>
                }})()}
        </div>
    )
}