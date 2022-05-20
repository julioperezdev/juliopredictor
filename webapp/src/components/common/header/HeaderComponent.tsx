import {Link } from 'react-router-dom'

import "./HeaderComponent.css";

export const HeaderComponent = () => {
    return(
    <div>
        <div className="mobileHeader">
            <Link
            to="/">
            <img 
            src="/image/home.png"
            className="headerIcon"/>
            </Link>
            <Link
            to="/crypto">
            <img 
            src="/image/dollar.png"
            className="headerIcon"/>
            </Link>
            <Link
            to="/favorite">
            <img 
            src="/image/heart.png"
            className="headerIcon"/>
            </Link>
            <Link
            to="/profile">
            <img 
            src="/image/address.png"
            className="headerIcon"/>
            </Link>
        </div>
        <div className="desktopHeader">
            <h1>juliopredictor</h1>
            <div>
                <Link
                to="/">
                <p>Home</p>
                </Link>
                <Link
                to="/crypto">
                <p>Cryptos</p>
                </Link>
                <Link
                to="/favorite">
                <p>Favorites</p>
                </Link>
                <Link
                to="/profile">
                <p>Profile</p>
                </Link>
            </div>
        </div>
    </div>
    )
}