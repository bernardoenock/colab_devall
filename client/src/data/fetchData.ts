import axios from 'axios';

import { Post } from '../interfaces/PostInterface';

export const fetchData = async (content: string = ''): Promise<Post[]> => {
  try {
    // const response = await axios.get(`https://api.devall.com.br/api/v2/post?content=${content}`);
    const response = await axios.get(`http://localhost:8080/api/v2/posts?search=${content}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw new Error('Failed to fetch data');
  }
};

export const getUrl = async (id: number): Promise<{url: string}> => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v2/posts/${id}/click`);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw new Error('Failed to fetch data');
  }
}
