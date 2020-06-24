#! /bin/bash
NPM_CONFIG_PATH="./frontend"
FRONTEND_PATH="./frontend/dist/"
BACKEND_PATH="./backend/src/main/resources/static/"

if cd $NPM_CONFIG_PATH; then
    if npm run > /dev/null 2>&1; then
        npm run build
    else
        echo "ERROR: npm unknown command! Aborting." 1>&2
        exit 1
    fi
    cd ..
else
        echo "ERROR: Could not change to directory $NPM_CONFIG_PATH! Aborting." 1>&2
        exit 1
fi

if [ -d "$BACKEND_PATH" ]; then
    rm -rf "$BACKEND_PATH"
fi

if [ -d "$FRONTEND_PATH" ]; then
    if type rsync > /dev/null; then
        rsync -c "$FRONTEND_PATH" "$BACKEND_PATH"
    else 
        cp -r "$FRONTEND_PATH" "$BACKEND_PATH"
    fi
else
    echo "ERROR: Could not copy from directory $FRONTEND_PATH! Aborting." 1>&2
    exit 1
fi
$shell
