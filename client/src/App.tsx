import { useState } from 'react';
import './App.css';
import { ListPosts } from './components/ListPosts';

function App() {
  const [started, setStarted] = useState(false);

  const handleStart = () => {
    setStarted(true);
  };

  return (
    <div className="app-container">
      {!started ? (
        <>
          <h1>🎮 Welcome to dev/All!</h1>
          <p>Press start to continue...</p>
          <button onClick={handleStart}>Start</button>

          <div className="pixel-box">
            <p>Power Up! By ENOCK🚀</p>
          </div>
        </>
      ) : (
        <ListPosts />
      )}
    </div>
  );
}

export default App;