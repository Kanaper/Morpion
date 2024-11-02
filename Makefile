PACKAGE = fr.kanaper.morpion
ENTRY = Main
SOURCEDIR = ./src/fr/kanaper/morpion/
BUILDDIR = ./build/
DOCDIR = ./doc/

SOURCES := $(foreach dir, $(wildcard $(SOURCEDIR)**/), $(dir)*.java)

all:
	@make compile
	@make run

compile:
	@echo "Compiling..."
	@javac -d $(BUILDDIR) $(SOURCEDIR)*.java $(SOURCES) -Xlint:unchecked -Xlint:deprecation
	@echo "Done."

run:
	@echo "Running..."
	@java -cp $(BUILDDIR) $(PACKAGE).$(ENTRY)
	@echo "Done."

clean:
	@echo "Cleaning up..."
	@rm -rf $(BUILDDIR)* $(DOCDIR)*
	@echo "Done."

javadoc:
	@echo "Generating javadoc..."
	@javadoc -d $(DOCDIR) -sourcepath src -subpackages $(PACKAGE)
	@echo "Done."

jar:
	@echo "Creating jar..."
	@jar cvfe $(PACKAGE).jar $(PACKAGE).$(ENTRY) -C $(BUILDDIR) $(PACKAGE)
	@echo "Done."