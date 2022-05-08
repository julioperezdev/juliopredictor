import "./HeaderComponent.css";

export const HeaderComponent = () => {
    return(
    <div>
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
        <div className="desktopHeader">
            <h1>juliopredictor</h1>
            <div>
                <p>Home</p>
                <p>Cryptos</p>
                <p>Favorites</p>
                <p>Perfil</p>
            </div>
        </div>
    </div>
    )
}