cd frontend;
npm run build;
cd ..;
rm -rf backend/src/main/resources/static/;
cp -r frontend/dist/ backend/src/main/resources/static;
bash