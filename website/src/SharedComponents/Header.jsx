import React from 'react';
import AnimatedLogo from "./AnimatedLogo";

const Header = ({title}) => {
    return (
        <div className={'navbar'}>
            <div className={'navbar-logo'}>
                <AnimatedLogo/>
                <div>
                    Team Loading
                </div>
            </div>
        {/*    title*/}
            <div className={'title'}>
                {title}
            </div>
        </div>
    );
};

export default Header;