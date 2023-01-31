import React from 'react';

const UmlImage = ({image,file}) => {
    return (
    //    image and download button for UML text
        <>
            <img src={image} alt={`image for UML`} className={'gantt-chart'}/>
            <button className={'download-button'} onClick={() => window.open(file)}>Download UML</button>

        </>
    );
};

export default UmlImage;
