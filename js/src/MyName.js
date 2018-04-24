import React from 'react';

const MyName = ({ name }) => {
    return (
        <div className="App">
            안녕하세요! <b>{name}</b> 입니다.
        </div>
    );
}

MyName.defaultProps = {
    name: '기본이름'
};

export default MyName;