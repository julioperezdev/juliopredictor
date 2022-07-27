import { useEffect, useState } from "react"
import { CoinMarketCapMapEntity } from "../../../models/CoinMarketCapMapEntity"
import {ParticularCurrency} from "../particularCurrency/ParticularCurrency"
import {ParticularCurrencyUnauthorized} from "../particularCurrencyUnauthorized/ParticularCurrencyUnauthorized"
import {isAuthenticated} from "common/AuthenticationHelper"

import "./CurrenciesList.css"

export const CurrenciesList = ({authenticationStatus,currencies}) => {

    const [currenciesConverted, setCurrenciesConverted] = useState<Array<CoinMarketCapMapEntity>>([]);
    const [isAuthenticatedState, setIsAuthenticatedState] = useState<boolean>(false);
    const converPropToCoinMarketCapMapEntity = () => {
        let currenciesVariables : Array<CoinMarketCapMapEntity> = currencies;
        setCurrenciesConverted(currenciesVariables);
        setIsAuthenticatedState(isAuthenticated(Number.parseInt(authenticationStatus)));
    }

    useEffect(() =>{converPropToCoinMarketCapMapEntity()},[])

    return(
        <ul className="currencies-list-base">
            {isAuthenticatedState
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