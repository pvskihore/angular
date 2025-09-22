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
  // This endpoint is not implemented in the backend yet.
  // I will just return an empty array for now.
  return Promise.resolve({ data: [] });
};

const documentService = {
  upload,
  getFiles,
};

export default documentService;
