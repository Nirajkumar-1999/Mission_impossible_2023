import React from "react";

const Hello = () => {
    // return (
    //     <div>
    //         <h1>Hello Darden Idiots</h1>
    //     </div>
    // )

    return React.createElement('div', null, React.createElement('h1', null, 'Hello Darden Idiots'))
}

export default Hello