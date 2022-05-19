import {EmailInput} from "../../common/emailInput/EmailInput"
import {CryptoList} from "../../favorites/cryptoList/CryptoList"

import {CryptoRankedByCmc} from "../../../models/Models"

import "./FavoriteCrypto.css"

export const FavoriteCrypto = ({authenticationStatus}) =>{

    const hasFavoriteCryptos = () => {
        var favoriteCrytos: Array<number> = [3];
        return favoriteCrytos.length !== 0;
    }

    const returningFavoriteCryptosByUser = () : Array<CryptoRankedByCmc> => {
        return [
            {id: 1,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 2,rank: 2,name: "Etherium", symbol: "ETH"},
            {id: 3,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 4,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 5,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 6,rank: 1,name: "Bitcoin", symbol: "BTC"},
            {id: 7,rank: 1,name: "Bitcoin", symbol: "BTC"} 
        ];
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
                        <EmailInput/>
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
                        <CryptoList
                        favoriteCryptosByUser = {returningFavoriteCryptosByUser()}/>}
                    </div>
                    </>
                }})()}
        </div>
    )
}