import logo from './logo.svg';
import './App.css';
import Greet from './components/Greet';
import Welcome from './components/Welcome';
import Hello from './components/Hello';
import Message from './components/Message';
import Counter from './components/Counter';

function App() {
  return (
    <div className="App">
     <Greet name="Chaitra"/>
     <Greet name="Nyana"/>
     <Welcome name="Nayana"/>
     <Welcome name="Chaitra"/>
     <Message/>
     <Hello/>
     <Counter/>
    </div>
  );
}

export default App;
