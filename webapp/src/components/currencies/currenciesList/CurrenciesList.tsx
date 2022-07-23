import { useEffect, useState } from "react"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity"
import {ParticularCurrency} from "../particularCurrency/ParticularCurrency"
import {ParticularCurrencyUnauthorized} from "../particularCurrencyUnauthorized/ParticularCurrencyUnauthorized"

import "./CurrenciesList.css"

export const CurrenciesList = ({authenticationStatus,currencies}) => {

    const [currenciesConverted, setCurrenciesConverted] = useState<Array<CoinMarketCapMapEntity>>([]);
    const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);
    const converPropToCoinMarketCapMapEntity = () => {
        let currenciesVariables : Array<CoinMarketCapMapEntity> = currencies;
        setCurrenciesConverted(currenciesVariables);
        setIsAuthenticated(isAuthenticatedFunction);
    }

    const isAuthenticatedFunction = () : boolean =>{
        return authenticationStatus === 2;
    }

    useEffect(() =>{converPropToCoinMarketCapMapEntity()},[])

    return(
        <ul className="currencies-list-base">
            {isAuthenticated
            ?currenciesConverted.map(particularCurrency => (
                <ParticularCurrency
                key={particularCurrency.id}
                {...particularCurrency}/>
            )):currenciesConverted.map(particularCurrency => (
                <ParticularCurrencyUnauthorized
                key={particularCurrency.id}
                {...particularCurrency}/>
            ))}
        </ul>
    )
}