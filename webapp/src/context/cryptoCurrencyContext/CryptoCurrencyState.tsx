import {useReducer} from 'react'
import CryptoCurrencyContext from "./CryptoCurrencyContext";
import CryptoCurrencyReducer from "./CryptoCurrencyReducer"
import HttpClient from "../../common/HttpClient";
import { PredictorRestResponse } from '../../models/PredictorRestResponse';
import { CoinMarketCapListTop300Response } from '../../models/CoinMarketCapListTop300Response';
import {GET_300_COINS} from "../types"

const CryptoCurrencyState = (props) => {

    const initialState : any = {
        allCoins : null,
        topCoins : null,
    }

    const [state, dispatch] = useReducer(CryptoCurrencyReducer, initialState);


    const getCoinMarketCapListTop300 = async () => {
        const responsePromise = await HttpClient.get(`/currencies/top300`);
        const response : PredictorRestResponse<CoinMarketCapListTop300Response> = responsePromise.data;
        if(response.statusCode === 302){
            //get coins
            console.log("entrooo 302")
            let result : PredictorRestResponse<CoinMarketCapListTop300Response> = response;
            dispatch({
                type: GET_300_COINS,
                payload: result.body
            })
        }
    }
        

    return(
        <CryptoCurrencyContext.Provider value= {{
            allCoins: state.allCoins,
            topCoins: state.topCoins,
            getCoinMarketCapListTop300,
        }}>
        {props.children}
        </CryptoCurrencyContext.Provider>
        
    )

}

export default CryptoCurrencyState;