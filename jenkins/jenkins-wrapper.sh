#! /bin/bash -e

BR=/var/backing/repo

if [ ! -z "$BACKING_REPO" ]; then
	echo "-- updating repo conf ${BR} from ${BACKING_REPO}.."
	test -d $BR && rm -rf $BR
	git clone $BACKING_REPO $BR
fi

# install plugins requested in repository
if [ -d "$BACKING_REPO/plugins.txt" ]; then
	/usr/local/bin/install-plugins.sh < "$BACKING_REPO/plugins.txt"
fi

# copy jobs and init.groovy.d into ref folder (jenkins.sh will copy them)
for x in jobs init.groovy.d; do
	if [ -d $BR/$x ]; then
		echo "-- copying files from $BR/$x.."
		cp -r $BR/$x /usr/share/jenkins/ref/
	fi
done

exec /usr/local/bin/jenkins.sh "$@"
