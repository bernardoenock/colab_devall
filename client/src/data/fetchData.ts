import axios from 'axios';

import { Post } from '../interfaces/PostInterface';

export const fetchData = async (content: string = ''): Promise<Post[]> => {
  try {
    const response = await axios.get(`https://api.devall.com.br/api/v2/post?content=${content}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw new Error('Failed to fetch data');
  }
};
