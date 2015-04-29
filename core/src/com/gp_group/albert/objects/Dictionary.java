package com.gp_group.albert.objects;

import com.badlogic.gdx.files.FileHandle;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author bluesialia
 *         Date: 9/03/15
 */
public class Dictionary {

    private final PatriciaTrie<String> _dictionary_;

    public Dictionary(FileHandle file) throws IOException {
        _dictionary_ = new PatriciaTrie<String>();
        BufferedReader reader = file.reader(8192);
        String line;
        for (line = reader.readLine(); line != null; line = reader.readLine()) {
            _dictionary_.put(line, line);
        }
    }

    public boolean exist(String word) {
        return _dictionary_.containsKey(word);
    }
}
