import { useEffect, useState } from "react";
import { isAuthenticated } from "common/AuthenticationHelper"
import { useParams } from "react-router-dom";
import { FavoritesCryptos } from "models/FavoritesCryptos";
import HttpClient from "common/HttpClient";
import { PredictionData } from "models/PredictorData";
import { PulseLoader } from "react-spinners";

import "./PredictorPage.css"
import { PredictorRestResponse } from "models/PredictorRestResponse";
import FiatCurrencies from "models/FiatCurrencies";

export default function PredicatorPage({ authenticationStatus }) {

    const [isAuthenticatedState, setIsAuthenticatedState] = useState(false);
    const { id } = useParams();
    const [crypto, setCrypto] = useState<PredictionData>(null)
    const [currencies, setCurrencies] = useState<Array<FiatCurrencies>>([])
    const [haveData, setHaveData] = useState<boolean>(false)
    let [loading, setLoading] = useState(true);
    let [color, setColor] = useState("#B2A4FF");
    const [symbol, setSymbol] = useState("USD")

    const getCryptoById = async () => {
        const request = {
            cryptoId: Number.parseInt(id),
            currency: symbol
        }
        const response = await HttpClient.post(`/predictor`, request);
        let responseTyped: PredictionData = await response.data.body;
        setCrypto(responseTyped)
        setLoading(false)
        setHaveData(true)
    }

    const getFiatCurrencies = async() =>{
        if(localStorage.getItem("currencies") === null){
            const response = await HttpClient.get(`/currencies/fiat`);
            let responseTyped: PredictorRestResponse<Array<FiatCurrencies>> = await response.data;
            setCurrencies(responseTyped.body)
            localStorage.setItem("currencies", JSON.stringify(currencies))
        }else if(localStorage.getItem("currencies") !== null){
            let responseTyped: Array<FiatCurrencies> = await JSON.parse(localStorage.getItem("currencies"));
            setCurrencies(responseTyped)
        }
    }

    const onClickSymbol = (symbol) =>{}

    const isPositive = (value: number): boolean => {
        return value > 0;
    }

    const returnUnsignalNumber = (value: number): string => {
        let valueConverted: string = value.toString();
        return isPositive(value) ? valueConverted : valueConverted.substring(1,valueConverted.length);
        //return valueConverted;
    }

    useEffect(() => {
        getFiatCurrencies()
        getCryptoById()
    }, [])

    useEffect(() => { setIsAuthenticatedState(isAuthenticated(authenticationStatus)) }, []);

    return (
        <>{!isAuthenticatedState
            ? <p>loader</p>
            : <div>
                {!haveData
                    ? <div className="currencies-page-sweet-loading">
                        <PulseLoader color={color} loading={loading} size={25} />
                    </div>
                    : <div className="predictor-base-information">
                        <div className="predictor-logo-currencies-base">
                            {crypto.isBull ? <div><img src="/profit.png"/><p>SUBIRA</p></div> : <div><img src="/loss.png"/><p>BAJARA</p></div>}
                            <img src={crypto.logo}/>
                            <p>{crypto.price}</p>
                            <p>BOTON ME GUSTA</p>
                            <select>
                                {currencies.map(particular =>(
                                    <option onClick={() => setSymbol(particular.symbol)} value={particular.symbol}>{particular.name}</option>
                                ))}
                            </select>
                        </div>
                        <div className="predictor-numbers-base">
                            <div>
                                <div className="predictor-subtitle">
                                    <p>Volumen de capitalizacion en USD</p>
                                    <img src="/volume.png" alt="" />
                                </div>
                                <div className="predictor-data-numbers-div-volume">
                                    <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.volume_24h).concat(" ")}</p>
                                </div>
                            </div>
                            <div>
                                <div className="predictor-subtitle">
                                    <p>Cambio porcentual del volumen en 24 horas</p>
                                    <img src="/chart.png" alt="" />
                                </div>
                                <div className="predictor-data-numbers-div">
                                    {isPositive(crypto.volume_change_24h) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                    <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.volume_change_24h)}</p>
                                </div>
                            </div>
                            <div>
                                <div className="predictor-subtitle">
                                    <p>Cambio porcentual del Precio</p>
                                    <img src="/percent.png" alt="" />
                                </div>
                                <div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 1 hora</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_1h) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_1h).concat(" %")}</p>
                                        </div>
                                    </div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 24 horas</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_24h) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_24h).concat(" %")}</p>
                                        </div>
                                    </div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 7 dias</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_7d) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_7d).concat(" %")}</p>
                                        </div>
                                    </div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 30 dias</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_30d) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_30d).concat(" %")}</p>
                                        </div>
                                    </div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 60 dias</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_60d) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_60d).concat(" %")}</p>
                                        </div>
                                    </div>
                                    <div className="predictor-data-base">
                                        <p className="predictor-data-description">cambio porcentual en 90 dias</p>
                                        <div className="predictor-data-image-number">
                                            {isPositive(crypto.percent_change_90d) ? <img src="/profits.png" /> : <img src="/loss.png" />}
                                            <p className="predictor-data-numbers">{returnUnsignalNumber(crypto.percent_change_90d).concat(" %")}</p>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>}
            </div>
        }
        </>
    )
}