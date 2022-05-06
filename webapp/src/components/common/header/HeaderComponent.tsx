import {useEffect} from "react";
import {useMediaQuery} from "react-responsive";
import "./HeaderComponent.css";

//import homeIcon from "../../../../public/home.png";

const MobileHeader = ({children}) =>{
    const isMobile = useMediaQuery({maxWidth: 767})
    return isMobile ? children : null;
}

const DesktopHeader = ({children}) =>{
    const isMobile = useMediaQuery({minWidth: 768})
    return isMobile ? children : null;
}

export const HeaderComponent = () => {
    useEffect(() =>{},[MobileHeader, DesktopHeader])
    return(
    <div>
        <MobileHeader>
            <div className="mobileHeader">
                <img 
                src="/image/home.png"
                className="headerIcon"/>
                <img 
                src="/image/dollar.png"
                className="headerIcon"/>
                <img 
                src="/image/heart.png"
                className="headerIcon"/>
                <img 
                src="/image/address.png"
                className="headerIcon"/>
            </div>
        </MobileHeader>
        <DesktopHeader>
            <div className="desktopHeader">
                <h1>juliopredictor</h1>
                <div>
                    <p>Home</p>
                    <p>Cryptos</p>
                    <p>Favorites</p>
                    <p>Perfil</p>
                </div>
            </div>
        </DesktopHeader>
    </div>
    )
}