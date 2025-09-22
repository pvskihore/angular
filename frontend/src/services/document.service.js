import api from './api';

const upload = (file, onUploadProgress) => {
  let formData = new FormData();

  formData.append('file', file);

  return api.post('/documents/upload', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
    onUploadProgress,
  });
};

const getFiles = () => {
  return api.get('/documents');
};

const documentService = {
  upload,
  getFiles,
};

export default documentService;
