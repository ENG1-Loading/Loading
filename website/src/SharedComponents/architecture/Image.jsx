import React from 'react';

const Image = ({image,alt,txt,className,fileName}) => {
    const onClick=()=>{
        fetch(txt)
            .then(response => response.blob())
            .then(blob => {
                const url = window.URL.createObjectURL(blob);
                const a = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = fileName
                document.body.appendChild(a);
                a.click();
                window.URL.revokeObjectURL(url);
            })
            .catch(error => console.log(error));
    }
    return (
        <div className={'image-container'}>
            <img src={image} alt={alt} className={className}/>
            <button className={'button'} onClick={onClick}>Download UML</button>
        </div>
    );
};

export default Image;