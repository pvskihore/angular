import api from './api';

const signup = (username, password, role) => {
  return api.post('/auth/signup', {
    username,
    password,
    role,
  });
};

const signin = (username, password) => {
  return api
    .post('/auth/signin', {
      username,
      password,
    })
    .then((response) => {
      if (response.data.token) {
        localStorage.setItem('user', JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem('user');
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem('user'));
};

const authService = {
  signup,
  signin,
  logout,
  getCurrentUser,
};

export default authService;
