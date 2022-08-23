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
                style={{ textDecoration: 'none' }}
                to="/">
                <p className='desktopHeader-link'>Home</p>
                </Link>
                <Link
                style={{ textDecoration: 'none' }}
                to="/crypto">
                <p className='desktopHeader-link'>Cryptos</p>
                </Link>
                <Link
                style={{ textDecoration: 'none' }}
                to="/favorite">
                <p className='desktopHeader-link'>Favorites</p>
                </Link>
                <Link
                style={{ textDecoration: 'none' }}
                to="/profile">
                <p className='desktopHeader-link'>Profile</p>
                </Link>
            </div>
        </div>
    </div>
    )
}