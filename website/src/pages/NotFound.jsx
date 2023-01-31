import React from 'react';
import { Link } from 'react-router-dom';
import '../static/NotFound.css'
import Header from "../SharedComponents/Header";
const NotFound = () => {
    return (
        <>
        <Header title={''} />

        <div className="not-found">
            <h1>404 - Page Not Found</h1>
            <p>Sorry, the page you are looking for does not exist.</p>
            <Link to="/">
                <button className="back-home-button">Back to Home</button>
            </Link>
        </div>
            </>
    );
};

export default NotFound;