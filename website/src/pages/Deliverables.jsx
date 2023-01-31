import React from 'react';
import '../static/deliverables.css'
import {FaFilePdf,FaDownload} from 'react-icons/fa'
import Header from "../SharedComponents/Header";
import {downloads} from "../content/downloads";

const Deliverables = () => {
    return (
        <>
            <Header title={'Deliverables'} />
        <div className="deliverables-app">
            {downloads.map((download, index) => {
                return (
            <div className="deliverables-card app-file-list">
                <div className="app-file-icon">
                    <FaFilePdf style={{ color: 'red', fontSize: '60px' }} />
                </div>
                <div className="description">
                    <div>
                        <div>{download.fileName}</div>
                        <div style={{ color: '#AFAFAF' }}>1.2mb</div>
                    </div>
                    <div>
                        <a href={download.file} download={download.fileName}  >
                        <FaDownload style={{
                            color: '#5e5e5e',
                            fontSize: '29px',
                            cursor: 'pointer',
                        }}/>
                        </a>
                    </div>
                </div>
            </div>)})}
        </div>
            </>
    );
};

export default Deliverables;
