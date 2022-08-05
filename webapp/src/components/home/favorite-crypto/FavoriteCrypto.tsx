import {EmailInput} from "../../common/emailInput/EmailInput"
import {CryptoList} from "../../favorites/cryptoList/CryptoList"

import {CryptoRankedByCmc} from "../../../models/Models"

import "./FavoriteCrypto.css"

export const FavoriteCrypto = ({authenticationStatus, decideAuth}) =>{

    const hasFavoriteCryptos = () => {
        var favoriteCrytos: Array<number> = [3];
        return favoriteCrytos.length !== 0;
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
                        <EmailInput
                        decideAuth = {decideAuth}/>
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
                        <CryptoList/>}
                    </div>
                    </>
                }})()}
        </div>
    )
}