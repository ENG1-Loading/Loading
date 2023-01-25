import React from 'react';
import LogoImage from './Logo.png'
const Logo = ({height,width}) => {
    return (
        <img src={LogoImage} alt={'logo'} height={height} width={width}/>
    );
};

export default Logo;