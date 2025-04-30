import { useEffect, useState } from 'react';
import { fetchData } from '../data/fetchData';
import { Post } from '../interfaces/PostInterface';
import './ListPosts.css';

export function ListPosts() {
  const [posts, setPosts] = useState<Post[]>([]);
  const [loading, setLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [allPosts, setAllPosts] = useState<Post[]>([]);

  useEffect(() => {
    fetchData()
      .then((data) => {
        setPosts(data);
        setAllPosts(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error(error);
        setLoading(false);
      });
  }, []);

  const handlePostClick = (id: number) => {
    const url = `https://api.devall.com.br/api/v2/post/${id}/click`;
    window.open(url, '_blank');
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value;
    setSearchTerm(value);

    const filtered = allPosts.filter((post) =>
      post.title.toLowerCase().includes(value.toLowerCase()) ||
      post.summary.toLowerCase().includes(value.toLowerCase())
    );
    setPosts(filtered);
  };

  const handleKeyDown = async (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === 'Enter') {
      try {
        setLoading(true);
        const serverPosts = await fetchData(searchTerm);
        setPosts(serverPosts);
        setAllPosts(serverPosts);
      } catch (error) {
        console.error(error);
      } finally {
        setLoading(false);
      }
    }
  };

  if (loading) {
    return <p>Loading... ⏳</p>;
  }

  return (
    <div className="app-container">
      <h1>📰 Crowler Posts</h1>

      <input
        type="text"
        value={searchTerm}
        onChange={handleInputChange}
        onKeyDown={handleKeyDown}
        placeholder="Search posts..."
        className="search-input"
      />

      <div className='container-posts'>
        {posts.map((post) => (
          <div
            key={post.id}
            className="pixel-box"
            onClick={() => handlePostClick(post.id)}
            style={{ cursor: 'pointer' }}
          >
            <h2>{post.title}</h2>
            <p>{post.summary}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
