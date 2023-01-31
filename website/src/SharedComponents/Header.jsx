import React from 'react';
import AnimatedLogo from "./AnimatedLogo";

const Header = ({title,buttonName,file,link}) => {
    const onButtonClick=()=>{
        if(link){
        //     open that link
            window.open(link)
            return
        }
        fetch(`../documents/${file}`)
            .then(response => response.blob())
            .then(blob => {
                const url = window.URL.createObjectURL(blob);
                const a = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = file
                document.body.appendChild(a);
                a.click();
                window.URL.revokeObjectURL(url);
            })
            .catch(error => console.log(error));
    }
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
            <div>
            {/*    download button*/}

                {buttonName&&<button className={'navbar-button'} onClick={onButtonClick}>
                    {buttonName}</button>}
            </div>
        </div>
    );
};

export default Header;
